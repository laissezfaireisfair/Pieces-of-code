#include <memory>
#include <cstdint>
#include <iostream>

template<class T> using wPtr = std::weak_ptr<T>;
template<class T> using sPtr = std::shared_ptr<T>;
template<class T> using uPtr = std::unique_ptr<T>;

int main() {
  using uint = std::uint64_t;
  uint size = 10;
  sPtr<uint[]> array(new uint[size], std::default_delete<uint[]>());
  for (std::uint8_t i = 0; i < size; ++i)
    array[i] = std::uint64_t(i);
  for (std::uint8_t i = 0; i < size; ++i)
    std::cout << array[i] << " ";
  std::cout << std::endl;
  return 0;
}
