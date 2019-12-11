#include "../../src/duck.cpp"
#include "../../src/flyBehaviours/flyWithWings.cpp"
#include "../../src/quackBehaviours/quack.cpp"
#include "../../include/duckSpecies/redheadDuck.hpp"
#include <iostream>
using namespace std;

int main() {
  SimUDuck::Duck *duck = new SimUDuck::RedheadDuck;
  cout << "Hi, I am redhead duck!" << endl;
  cout << duck->quack() << endl;
  cout << duck->swim() << endl;
  cout << duck->fly() << endl;
  delete duck;
  return 0;
}
