#! /bin/bash
#* check strings with switch-case

os="Manjaro"
case $os in
    "Arch Linux" | Manjaro) echo "OS matched" ;;
    Fedora | CentOS) echo -n "Red Hat based OS" ;;
esac
