#pragma once
#include "../duck.hpp"
#include "../flyBehaviours/flyNoWay.hpp"
#include "../quackBehaviours/squeak.hpp"

namespace SimUDuck {

class RubberDuck : public Duck {
public:
  RubberDuck() {
    flyBehaviour = new FlyNoWay;
    quackBehaviour = new Squeak;
    name = "Rubber duck";
  }
};

}
