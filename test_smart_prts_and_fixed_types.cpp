#include <memory>
#include <cstdint>
#include <iostream>

template<class T> using wPtr = std::weak_ptr<T>;
template<class T> using sPtr = std::shared_ptr<T>;

int main() {
  std::uint8_t size = 10;
  sPtr<std::uint64_t> array = std::make_shared<uint64_t>(size);
  for (std::uint8_t i = 0; i < size; ++i)
    array[i] = std::uint64_t(i);
  for (std::uint8_t i = 0; i < size; ++i)
    std::cout << array[i] << " ";
  std::cout << endl;
  return 0;
}
