'use strict';

let uniqueId = Symbol('userIdSymbol');

let id = Symbol.for('userIdSymbol')  // Creating it in global storage
function User(name) {
    return {
        name: name,
        [id]: 'veryHiddenId',  // Equivalent to: user[id] = 1
    };
}

let user = User('Andrey');
let userIdSymbol = Symbol.for('userIdSymbol');
console.assert(id === userIdSymbol)
console.assert(uniqueId !== userIdSymbol)
// alert(user[userIdSymbol]);

console.log(`228 in binary: ${228..toString(2)}`)
console.log(`Parsed 118.3: ${parseFloat('118.3').toString()}`)

let str = 'hello'
console.assert(str.at(-1) === 'o')
console.assert(str[-1] === undefined)

console.assert('a' > 'Z')

let arr = ['Hey-o', {author: 'Thousand foot crutch'}, {title: 'Courtesy Call'}]
arr.push('Excellent', 'Perfect')

arr.filter(elem => typeof elem === 'string')
    .map(elem => elem + ' ' + elem.length)
    .forEach(elem => console.log(elem))

const text = ['Hey-o,', 'here', 'comes', 'the', 'danger', 'up', 'in', 'this', 'club']
    .reduce((s, acc) => s + ' ' + acc, '');
console.log(text)

/// Creating custom iterator
let range = {
    from: 1,
    to: 5
}

range[Symbol.iterator] = function () {
    return {
        current: this.from,
        last: this.to,
        next() {
            if (this.current <= this.last) {
                return {done: false, value: this.current++}
            }
            return {done: true}
        }
    }
}

for (let num of range) {
    console.log(num)
}
/// /Creating custom iterator

// Array destructuring
let nameSurname = ['Andrey', 'Ivanovich', 'Golubev', 'some', 'extra', 'data']
let [name = 'Jonn', /* ignored entry */, surname = 'Doe', ...rest] = nameSurname
console.log(`${name} ${surname}: ${rest.toString()}`)
// /Array destructuring

// Object destructuring
let options = {
    title: 'Menu',
    width: 1920,
    height: 1080
}
let {width, height: myHeightVarName, title = 'default title'} = options
console.log(width)
console.log(myHeightVarName)
console.log(title)

// Nested destructuring
let complex = {
    size: {
        width: 1920,
        height: 1080
    },
    items: ['File', 'Edit'],
    isMaximised: true
}
let {
    size: {
        width: complexWidth,
        height: complexHeight
    },
    items: [complexItem1, complexItem2],
    isMaximised: isComplexMaximised = false
} = complex
console.log(`${complexWidth}x${complexHeight}: ${complexItem1}, ${complexItem2}; maximised: ${isComplexMaximised}`)
// /Nested destructuring

let args = {
    title: 'Menu',
    items: ['File', 'Edit', 'View']
};

function showMenu({
    title = "Untitled",
    width: w = 100,
    height: h = 200,
    items: [item1, item2, item3]
                  }) {
    console.log(`${title} ${w} ${h}`)
    console.log(item1)
    console.log(item2)
    console.log(item3)
}

showMenu(args)
// /Object destructuring
