#!/bin/csh
set A = 1
set B = 2
set C = 3
foreach i (A B C)
   eval echo \$$i
end
