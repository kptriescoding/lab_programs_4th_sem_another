#! /bin/csh

set var = "outer"
setenv VAR "outer"

echo "outer: $var $VAR"

csh usp12.csh haha

echo "outer: $var $VAR"
