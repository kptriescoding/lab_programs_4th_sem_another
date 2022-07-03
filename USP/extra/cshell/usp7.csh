#!/bin/csh

@ var=1

while ( $var < 20 )
touch usp$var.csh
chmod u+x usp$var.csh
gedit usp$var.csh
@ var= $var + 1 
end

