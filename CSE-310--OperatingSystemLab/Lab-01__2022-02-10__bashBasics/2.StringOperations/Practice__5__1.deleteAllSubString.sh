#! /bin/bash
#* delete all occurrences of substring by replacing with empty string

string="to be or not to be"
echo ${string[@]// be/}        # to or not to
