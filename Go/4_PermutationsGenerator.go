package permutations

import "fmt"

func revert(sequence []int) {
  return sequence[]
}

func slice_cpy(slice []int) copy []int {
  copy = make([]int, len(slice))
  copy(copy, slice)
  return copy
}

func Gen_next_permutation(sequence []int) (shuffled []int, err error) {
  if len(sequence) < 2 {
    err = fmt.ErrorF("Too short sequence to permutate.")
    return nil, err
  }
  shuffled = slice_cpy(sequence)
  suffixBegin := len(shuffled) - 1
  var rotatePoint int = nil
  for ; suffixBegin >= 0; suffixBegin-- {
    if suffixBegin == 0 {
      err = fmt.ErrorF("Last permutation have already reached.")
      return nil, err
    }
    if shuffled[suffixBegin - 1] < shuffled[suffixBegin] {
      rotatePoint = suffixBegin - 1;
      break
    }
  }
  for i = len(shuffled) - 1; i > rotatePoint; --i {
    if shuffled[i] > shuffled[rotatePoint] {
      shuffled[i], shuffled[rotatePoint] = shuffled[rotatePoint], shuffled[i]
      break
    }
  }
  revert(shuffled[len(shuffled):rotatePoint])
  return shuffled, nil
}

func main() {
  sequence := []int{1, 2, 3, 4, 5}
  fmt.Println(sequence)
  fmt.Println("Gen next permutaton...")
  permutatedSeq = Gen_next_permutation(sequence)
  fmt.Println(permutatedSeq)
}
