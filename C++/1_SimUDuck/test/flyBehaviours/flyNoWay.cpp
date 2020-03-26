#include "../../src/flyBehaviours/flyNoWay.cpp"
#include <iostream>
using namespace std;

int main() {
  SimUDuck::FlyBehaviour *flyNoWay = new SimUDuck::FlyNoWay();
  cout << "Fly no way status: " << flyNoWay->fly() << endl;
  delete flyNoWay;
  return 0;
}
