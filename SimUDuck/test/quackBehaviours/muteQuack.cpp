#include "../../src/quackBehaviours/muteQuack.cpp"
#include <iostream>
using namespace std;

int main() {
  SimUDuck::QuackBehaviour *quackBehaviour = new SimUDuck::MuteQuack;
  cout << "Mute quack status: " << quackBehaviour->quack() << endl;
  delete quackBehaviour;
  return 0;
}
