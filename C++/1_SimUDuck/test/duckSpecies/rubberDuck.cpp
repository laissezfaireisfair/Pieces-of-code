#include "../../src/duck.cpp"
#include "../../src/flyBehaviours/flyNoWay.cpp"
#include "../../src/quackBehaviours/squeak.cpp"
#include "../../include/duckSpecies/rubberDuck.hpp"
#include <iostream>
using namespace std;

int main() {
  SimUDuck::Duck *duck = new SimUDuck::RubberDuck;
  cout << "Hi, I am rubber duck!" << endl;
  cout << duck->quack() << endl;
  cout << duck->swim() << endl;
  cout << duck->fly() << endl;
  delete duck;
  return 0;
}
