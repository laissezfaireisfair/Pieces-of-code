#include "../../src/quackBehaviours/squeak.cpp"
#include <iostream>
using namespace std;

int main() {
  SimUDuck::QuackBehaviour *quackBehaviour = new SimUDuck::Squeak;
  cout << "Squeak status: " << quackBehaviour->quack() << endl;
  delete quackBehaviour;
  return 0;
}
