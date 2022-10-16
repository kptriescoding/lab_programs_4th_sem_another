#!/bin/bash
if ! test -d $1
then
echo "Invalid directory"
exit
fi
echo "Contents of directory are"
ls -lR $1
echo "Enter permission"
read per
ls -lR $1 | grep -e $per
