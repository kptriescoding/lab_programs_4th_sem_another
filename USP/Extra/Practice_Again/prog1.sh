#!/bin/bash
if ! test -e $1
then
echo "The file doesn't exist"
elif test -h $1
then
echo "The file is a symbollic link file"
elif test -p $1
then
echo "The file is a fifo file"
elif test -b $1
then
echo "The file is a block device file"
elif test -c $1
then
echo "The file is a character device file"
elif test -d $1
then
echo "The file is a directory file"
elif test -f $1
then
echo "The file is a regular file"
else
echo "The file is of some other type"
fi
