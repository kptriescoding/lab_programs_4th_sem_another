#!/bin/csh

if ( $#argv == 0 ) then
@ min=$<
else
@ min=$1
endif

@ sec= $min * 60
echo $sec

