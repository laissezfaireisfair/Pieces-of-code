'use strict';

const DUE_DATE = '28.03.2013'

let message = 'hello';  // Old code uses 'var' instead, but it does not follow visibility
let numExample = 25,
    numExample2 = 11;

let copy = message;
message = 'world';

const copy2 = copy;

let inf = Infinity * 2;
let nan = NaN * 2;

const bigInt = 1234n;

const strTemplate = `Template ${message}`;

let flag = true;

let nullVal = null;

let conflict = 20 + 'str';

let result = prompt('Message', 'Default optional text');  // IE requires the default parameter

let isConfirmed = confirm("Message")

let castToStr = String(10)

let castToNum = Number('100')  // NaN if failed

let castToBool = Boolean(0)  // '0' str is true

let mod = 1 % 2

let pow = 2 ** 3

pow += 3

++pow

let comparison = 'abc' < 'ca'  // Lexicographical by unicode

let strictComparison = 0 === false;  // Comparison without cast - false

let nullSafe = null ?? 'abc';

function showMessage(text = 'message') {
    alert(text);
}

let showFunc = function(text) {
    alert(text);
};

let sum = (a,b) => a + b;
