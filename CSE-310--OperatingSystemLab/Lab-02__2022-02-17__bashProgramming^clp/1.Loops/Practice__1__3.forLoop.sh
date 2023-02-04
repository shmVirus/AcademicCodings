#! /bin/bash
#* exploring for-loop syntax
for i in {0..10..2}; do # {#..#..#], last # works as interval of range #..#
    echo "welcome $i times"
done
#for i in {0..10..$( expr 5 - 2 )}; do
#  echo "Hello $i times"
#done
