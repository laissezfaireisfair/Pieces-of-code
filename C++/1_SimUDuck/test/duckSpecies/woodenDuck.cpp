#include "../../src/duck.cpp"
#include "../../src/flyBehaviours/flyNoWay.cpp"
#include "../../src/quackBehaviours/muteQuack.cpp"
#include "../../include/duckSpecies/woodenDuck.hpp"
#include <iostream>
using namespace std;

int main() {
  SimUDuck::Duck *duck = new SimUDuck::WoodenDuck;
  cout << "Hi, I am wooden duck!" << endl;
  cout << duck->quack() << endl;
  cout << duck->swim() << endl;
  cout << duck->fly() << endl;
  delete duck;
  return 0;
}
