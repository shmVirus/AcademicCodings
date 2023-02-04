#! /bin/bash
#* traversing array using for−loop

array=(1 3 5 2 4)
for i in "${array[@]}"; do
    echo $i     # access each element as $i
done
