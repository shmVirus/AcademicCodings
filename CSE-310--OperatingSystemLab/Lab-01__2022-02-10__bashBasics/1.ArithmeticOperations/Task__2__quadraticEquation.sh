#! /bin/bash
#* solving quadratic equation

#* '${variable#-}' command strips if 'variable' contains negative value
#* '$variable^2' without bc doesn't eliminate '-' sign
#* 'base**exponent' command for bash exponent, '$' required for variable

read a
if [ $a == 0 ]; then
    echo "Invalid Quadratic Equation!"
    exit 0
fi
read b
read c

discriminant=$(( $b**2 - 4*$a*$c ))

if [ $discriminant -eq 0 ]; then
    x=`echo "scale=2; $((-$b)) / $((2*$a))" | bc `
    echo Roots: X = $x
elif [ $discriminant -gt 0 ]; then
    x1=`echo "($((-$b))+(sqrt(($b^2)-(4*$a*$c))))/(2*$a)" | bc`
    x2=`echo "($((-$b))-(sqrt(($b^2)-(4*$a*$c))))/(2*$a)" | bc`
    echo Roots: X1 = $x1, X2 = $x2
else
    discriminant=${discriminant#-}
    x1="$(( $((-$b)) / 2*$a ))+i"`echo "scale=2;sqrt($discriminant)/2*$a" | bc`
    x2="$(( $((-$b)) / 2*$a ))-i"`echo "scale=2;sqrt($discriminant)/2*$a" | bc`
    echo Roots: X1 = $x1,  X2 = $x2
fi
