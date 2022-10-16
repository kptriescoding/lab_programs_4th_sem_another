#!/bin/bash
if ! test -f $1
then
echo "Invalid file"
exit
fi
var1=$(wc --line $1)
var2=($var1)
echo "The No of line in $1 is ${var2[0]}"
