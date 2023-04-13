#! /bin/bash
#* match substring with different ways

truth="Microsoft is piece of shit."

if [[ $truth == *Microsoft* &&  $truth == *shit* ]]; then
    echo "True, but some dumbs doesn't accept!"
else
    echo "Are you comedy me?"
fi
if [[ $truth == *Microsoft* ]]; then
    echo "It's about Microsoft!"
else
    echo "It's not about Microsoft!"
fi
