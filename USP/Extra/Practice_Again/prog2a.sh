#!/bin/bash
echo "Enter string"
read string
echo "Enter LEN"
read LEN
echo "Enter POS"
read POS
echo ${string:$POS:$LEN}
