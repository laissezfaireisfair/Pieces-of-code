#pragma once
#include <string>

namespace SimUDuck {

class FlyBehaviour {
public:
  virtual std::string fly() const = 0;
};

}
