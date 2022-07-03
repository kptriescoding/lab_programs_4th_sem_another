#! /bin/csh

if ( ! $?var ) set var = "unknown"
echo "inner: $var $VAR"

set var = "inner"
setenv VAR "inner"

echo "inner: $var $VAR"
