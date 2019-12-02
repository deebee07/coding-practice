#!/bin/bash
# https://leetcode.com/problems/tenth-line/
# Devashish Badlani: Dec-1-2019

# head command: prints top N number of data of the given input
# tail command: prints last N number of data of the given input
# wc command: used to find out number of line count with flag -l

ROW_COUNT=`head -n 10 file.txt | wc -l`

if (( $ROW_COUNT == "10" )); then
    head -n 10 file.txt | tail -n 1 
else
    echo ""
fi