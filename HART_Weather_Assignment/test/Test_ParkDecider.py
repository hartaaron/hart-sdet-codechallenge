from src.WeatherBusiness import ParkDecider

import unittest
from ddt import data, ddt, unpack

@ddt
class Test_ParkDecider(unittest.TestCase):

    get_weather_temp_except = "park defined or rest call threw an exception"

    @data(["FL,Orlando", 62.1], ["CA,Anaheim", 62.1])
    @unpack
    def test_mock_Weather_Temp(self, input_location, expected_temp):
        pd_obj = ParkDecider(mock=True)
        temperature = pd_obj.getWeatherTemp(input_location)

        self.assertEqual(temperature, float(expected_temp))

    @data(["FL,Orlando"], ["CA,Anaheim"])
    @unpack
    def test_mock_both_locations(self, input_location):
        pd_obj = ParkDecider(mock=True, mock_winner=input_location)
        bestPark = pd_obj.getOptimalPark()

        self.assertEqual(bestPark, input_location)

    @data(["jlsda;ldsfjk;", get_weather_temp_except ], ["CA,muuut", get_weather_temp_except])
    @unpack
    def test_incorrect_weather_location_bad_format(self, input_location, expected):
        pd_obj = ParkDecider()
        act_exception = pd_obj.getWeatherTemp(input_location)

        self.assertEqual(act_exception, expected)

    @data(["FL,Orlando", 92.8], ["CA,Anaheim", 88.3])
    @unpack
    def test_Weather_Temp(self, input_location, expected):
        pd_obj = ParkDecider()
        act_temp = pd_obj.getWeatherTemp(input_location)

        self.assertEqual(act_temp, float(expected))

    @data([["FL,Orlando", "CA, Anaheim"], "CA, Anaheim"])
    @unpack
    def test_winner_for_best_park(self, input_parks, expected_park):
        pd_obj = ParkDecider(parks=input_parks)
        act_temp = pd_obj.getOptimalPark()

        self.assertEqual(act_temp, expected_park)

