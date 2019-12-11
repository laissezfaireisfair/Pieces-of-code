#pragma once
#include "../flyBehaviour.hpp"

namespace SimUDuck {

class FlyWithWings : public FlyBehaviour {
public:
  std::string fly() const;
};

}
