'use strict';
var redis = require("redis");
exports.handler = (event, context, globalCallback) => {
    context.callbackWaitsForEmptyEventLoop = false;
    console.log('Creating client.');
    let redisClient = redis.createClient(6379,"redisdemo.d6wtob.0001.apse1.cache.amazonaws.com", {no_ready_check: true});
    console.log('Client created.');
    event.Records.forEach((record) => {
        console.log('Event: ' + record.eventName + ' - ' + record.eventID);
        let key = record.dynamodb.Keys.Number.N;
        console.log('Key identified: ' + key);
        if (record.eventName === "INSERT" || record.eventName === "MODIFY") {
            let value = JSON.stringify(record.dynamodb.NewImage);
            console.log('Inserting value: ' + value);
            redisClient.set(key, value, function(err) {
                globalCallback(err);
            });
            console.log('Value inserted.');
        } else if (record.eventName === "REMOVE") {
            console.log('Removing key/value.');
            redisClient.del(key, function(err) {
               globalCallback(err);
            });
            console.log('Value removed.');
        }
    });
    console.log('Successfully processed.');
    globalCallback(null, `Successfully processed ${event.Records.length} records.`);
}