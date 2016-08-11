import requests

class ParkDecider:
    def __init__(self, mock=False, parks=["CA,Anaheim", "Orlando,Florida"], mock_winner='CA,Anaheim'):
        self.parks = parks
        self.mock = mock
        self.base_url = 'http://api.wunderground.com/api/06c8fec6a3511479/conditions/q/'
        self.mock_winner = mock_winner

    def getOptimalPark(self):
        if self.mock:
            return self.mock_winner
        else:
            pass

    def getWeatherTemp(self, park):
        temperature = None

        if self.mock:
            temperature = float(62.1)
        else:
            try:
                state, city = park.split(',')
                r = requests.get(self.base_url + state + '/' + city + '.json')
                temperature = r.json()['current_observation']['temp_f']
            except:
                return "park defined or rest call threw an exception"

        return float(temperature)

    