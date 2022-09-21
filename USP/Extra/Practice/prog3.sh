#!/bin/bash
if test -d $1
then
echo "The contents of the directory are"
ls -lR $1
else
echo "The given directory is invalid"
exit
fi
echo "Enter the permission to be filtered"
read PER
echo "The filtered files are"
ls -lR $1 | grep -e $PER

