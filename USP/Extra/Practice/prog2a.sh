#!/bin/bash

echo "Enter the string"
read STRING
echo "Enter the pos"
read POS
echo "Enter the len"
read LEN
echo "The required substring is -> ${STRING:$POS:$LEN}" 
