#!/bin/bash

if ! test -e $1
then
echo "The given file is invalid"
elif test -h $1
then
echo "The given file is a symbollic link file"
elif test -b $1
then
echo "The given file is a block device file"
elif test -c $1
then
echo "The given file is a character device file"
elif test -d $1
then
echo "The given file is a directory file"
elif test -f $1
then
echo "The given file is a regular file"
else
echo "The given file some other kind of file"
fi
