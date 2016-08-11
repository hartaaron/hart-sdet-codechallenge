import requests

class ParkDecider:
    def __init__(self, idea_temp=float(78),mock=False, parks=["CA,Anaheim", "FL,Orlando"], mock_winner='CA,Anaheim'):
        self.parks = parks
        self.idea_temp = idea_temp

        #TODO decouple using
        self.mock = mock
        self.base_url = 'http://api.wunderground.com/api/06c8fec6a3511479/conditions/q/'
        self.mock_winner = mock_winner

    def getOptimalPark(self):
        if self.mock:
            return self.mock_winner
        else:
            winning_park = None
            winning_diff = None
            for park in self.parks:
                temperature = self.getWeatherTemp(park)  #TODO assume no repeat
                temp_diff = abs(self.idea_temp - temperature)
                if winning_diff is None or temp_diff < winning_diff:
                    winning_park = park
                    winning_diff = temp_diff

            return winning_park

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