#!/bin/bash
# Use this for your user data (script without newlines)
# install httpd (Linux 2 version)
yum update -y
yum install -y httpd.x86_64
systemctl start httpd.service
systemctl enable httpd.service
echo "Hello World from $(hostname -f)" > /var/www/html/index.html

sudo su
yum update -y
yum install httpd -y
systemctl start httpd
systemctl enable httpd
echo "Getting started with AWS" > /var/www/html/index.html
echo "Welcome to AWS $(whoami)" > /var/www/html/index.html
echo "Welcome to AWS $(hostname)" > /var/www/html/index.html
echo "Welcome to AWS $(hostname -i)" > /var/www/html/index.html

#!/bin/bash
yum update -y
yum install -y httpd
systemctl start httpd
systemctl enable httpd
curl -s http://169.254.169.254/latest/dynamic/instance-identity/document > /var/www/html/index.html

#!/bin/bash
curl -s http://169.254.169.254/latest/dynamic/instance-identity/document > /var/www/html/index.html
mkdir /var/www/html/a
echo “Microservice A” > /var/www/html/a/test.html
