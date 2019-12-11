#pragma once
#include "../duck.hpp"
#include "../flyBehaviours/flyWithWings.hpp"
#include "../quackBehaviours/quack.hpp"

namespace SimUDuck {

class RedheadDuck : public Duck {
public:
  RedheadDuck() {
    flyBehaviour = new FlyWithWings;
    quackBehaviour = new Quack;
    name = "Redhead duck";
  }
};

}
