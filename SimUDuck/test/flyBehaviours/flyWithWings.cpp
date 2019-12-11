#include "../../src/flyBehaviours/flyWithWings.cpp"
#include <iostream>
using namespace std;

int main() {
  SimUDuck::FlyBehaviour *flyWithWings = new SimUDuck::FlyWithWings();
  cout << "Fly with wings status: " << flyWithWings->fly() << endl;
  delete flyWithWings;
  return 0;
}
