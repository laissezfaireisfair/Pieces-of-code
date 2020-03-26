#include "../../src/quackBehaviours/quack.cpp"
#include <iostream>
using namespace std;

int main() {
  SimUDuck::QuackBehaviour *quackBehaviour = new SimUDuck::Quack;
  cout << "Quack status: " << quackBehaviour->quack() << endl;
  delete quackBehaviour;
  return 0;
}
