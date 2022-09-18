#!/bin/bash
if ! test -e $1
then
echo "The given file is invalid"
elif test -h $1
then
echo "The given file is a Symbolic File"
elif test -b $1 
then
echo "The given file is a Block Device File"
elif test -c $1
then
echo "The given file is a Character Device File"
elif test -d $1
then
echo "The given file is a Directory File"
elif test -f $1
then
echo "The given file is a Regular File"
fi