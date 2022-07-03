#!/bin/csh

#repeat 10 echo “go home”

 #set list = ( one two three )
  #foreach word ( $list )
#		echo $word
 # end
 
@ sum = 0
foreach file (`ls`)
        set size = `cat $file | wc -c`
        echo "Counting: $file ($size)"
        @ sum = $sum + $size
end
echo Sum: $sum


