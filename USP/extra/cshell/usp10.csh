#!/bin/csh

set hours=`date`

echo $hours

echo $hours[4]

foreach hour ( $hours )
echo $hour
end
