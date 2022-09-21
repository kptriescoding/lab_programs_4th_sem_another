#!/bin/bash
if test -f $1
then
var1=$(wc --line $1)
var2=($var1)
echo "The number of lines in the file is $var2"
else 
echo "The given file is invalid"
fi

