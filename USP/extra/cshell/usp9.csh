#! /bin/csh
set hour=`date`
switch ($hour[4])
    case 0*:
    case 1[01]*:
          set greeting=morning ; breaksw
    case 1[2-7]*:
          set greeting=afternoon ; breaksw
    default:
          set greeting=evening
endsw
echo Good $greeting $1
