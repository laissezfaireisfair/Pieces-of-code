#pragma once
#include "../flyBehaviour.hpp"

namespace SimUDuck {

class FlyNoWay : public FlyBehaviour {
public:
  std::string fly() const;
};

}
