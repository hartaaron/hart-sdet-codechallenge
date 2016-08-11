from src.WeatherBusiness import ParkDecider

import unittest
import ddt

class ParkDecider_Test(unittest.TestCase):

    def test_mock_CA_Anaheim_Weather(self):
        pd_obj = ParkDecider(mock=True)
        temperature = pd_obj.getWeatherTemp('CA,Anaheim')

        self.assertEqual(temperature, float(62.1))

    def test_mock_FL_Orlando_Weather(self):
        pd_obj = ParkDecider(mock=True)
        temperature = pd_obj.getWeatherTemp('FL,Orlando')

        self.assertEqual(temperature, float(62.1))

    def test_FL_Orlando_Weather(self):
        pd_obj = ParkDecider()
        temperature = pd_obj.getWeatherTemp('FL,Orlando')

        self.assertEqual(temperature, float(92.8))

    def test_CA_Anaheim_Weather(self):
        pd_obj = ParkDecider()
        temperature = pd_obj.getWeatherTemp('CA,Anaheim')
        self.assertEqual(temperature, float(82.2))

    def test_mock_both_locations(self):
        pd_obj = ParkDecider(mock=True)
        bestPark = pd_obj.getOptimalPark()

        self.assertEqual(bestPark, "CA,Anaheim")

    def test_mock_both_locations(self):
        pd_obj = ParkDecider(mock=True, mock_winner="FL,Orlando")
        bestPark = pd_obj.getOptimalPark()

        self.assertEqual(bestPark, "FL,Orlando")

    def test_incorrect_weather_location_bad_format(self):
        pd_obj = ParkDecider()
        exception = pd_obj.getWeatherTemp("jlsda;ldsfjk;")

        self.assertEqual("park defined or rest call threw an exception", exception)


    def test_incorrect_weather_location_good_format(self):
        pd_obj = ParkDecider()
        exception = pd_obj.getWeatherTemp("CA,muuut")

        self.assertEqual("park defined or rest call threw an exception", exception)


