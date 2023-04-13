var x = 0;
const a = 12.55;
const b = 19;
const c = 17.5;
const d = 11.55;

function printer() {
    document.getElementById("res").innerHTML = x.toString();
}

function ty1() {
    x = x + a;
    printer();
}
function ty2() {
    x = x + b;
    printer();
}
function ty3() {
    x = x + c;
    printer();
}
function ty4() {
    x = x + d;
    printer();
}