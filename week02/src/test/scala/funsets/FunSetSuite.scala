package funsets

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import FunSets._

@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  test("Function contain is implemented and return true") {
    assert(contains(x => true, 100))
  }

  trait TestFunSets {
    val objectOne = singletonSet(1)
    val objectFive = singletonSet(5)
    val objectTen = singletonSet(10)
  }

  test("Function singletonSet(1) works fine") {
    new TestFunSets {
      assert(contains(objectOne, 1))
    }
  }

  test("Function union contains all elements") {
    new TestFunSets {
      val objectUnion = union(objectOne, objectFive)
      assert(contains(objectUnion, 1))
      assert(contains(objectUnion, 5))
    }
  }

  test("Function intersect works fine") {
    new TestFunSets {
      val objectUnionA = union(objectOne, objectFive)
      val objectUnionB = union(objectFive, objectTen)
      val objectInserct = intersect(objectUnionA, objectUnionB)
      assert(contains(objectInserct, 5))
      assert(!contains(objectInserct, 1))
      assert(!contains(objectInserct, 10))
    }
  }

  test("Function diff works fine") {
    new TestFunSets {
      val objectUnionA = union(objectOne, objectFive)
      val objectUnionB = union(objectFive, objectTen)
      val objectDiff = diff(objectUnionA, objectUnionB)
      assert(!contains(objectDiff, 10))
      assert(contains(objectDiff, 1))
      assert(!contains(objectDiff, 5))
    }
  }

  test("Function filter works fine") {
    new TestFunSets {
      val objectUnionA = union(objectOne, objectFive)
      var objectFiltered = filter(objectUnionA, (x:Int)=>x>=5)
      assert(!contains(objectFiltered, 1))
      assert(contains(objectFiltered, 5))
    }
  }

  test("Function map works fine") {
    new TestFunSets {
      val objectUnion = union(objectOne, objectFive)
      val objectMap = map(objectUnion, _+5)
      assert(contains(objectMap, 6))
      assert(contains(objectMap, 10))
    }
  }

}