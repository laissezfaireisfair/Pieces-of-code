#pragma once
#include "../duck.hpp"
#include "../flyBehaviours/flyNoWay.hpp"
#include "../quackBehaviours/muteQuack.hpp"

namespace SimUDuck {

class WoodenDuck : public Duck {
public:
  WoodenDuck() {
    flyBehaviour = new FlyNoWay;
    quackBehaviour = new MuteQuack;
    name = "Wooden duck";
  }
};

}
