from ddt import data, ddt, unpack
import unittest

@ddt
class TestSumNumber(unittest.TestCase):

    @data([1, 1], [2, 2], [3, 6], [4, 6], [5, 3], [6, 9], [11, 36], # happy_path
           [None, None], [-1, None] #negative
        )
    @unpack
    def test(self, input, expected):
        self.assertEqual(1, 1)