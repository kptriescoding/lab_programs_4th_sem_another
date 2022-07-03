#! /bin/csh
set list = "text.txt"
if ( $#argv == 0 ) then
   echo -n "Enter name OR z-id: "
   set name = $<
else
   set name = $*
endif
grep -i "$name" $list
if ( $status ) echo "$name not found"
