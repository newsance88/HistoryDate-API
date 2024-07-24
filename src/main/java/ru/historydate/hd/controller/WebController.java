package ru.historydate.hd.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.historydate.hd.dto.HistoryDateDto;
import ru.historydate.hd.dto.PeriodDto;
import ru.historydate.hd.service.HistoryDateService;
import ru.historydate.hd.service.PeriodService;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/web")
public class WebController {

    private HistoryDateService historyDateService;
    private PeriodService periodService;

    @GetMapping("/list")
    public ModelAndView displayArticle(Map<String, Object> model) {

        List<HistoryDateDto> historyDates = historyDateService.getAllHistoryDates();

        model.put("historyDates", historyDates);

        return new ModelAndView("index", model);
    }

    @GetMapping("/form")
    public ModelAndView showAddHistoryDateForm(Map<String, Object> model) {
        HistoryDateDto historyDateDto = new HistoryDateDto();
        model.put("centuries", periodService.getAllCentury());
        model.put("historyDateDto", historyDateDto);
        return new ModelAndView("add-history-date", model);
    }

    @PostMapping("/form")
    public ModelAndView addHistoryDate(@ModelAttribute HistoryDateDto historyDateDto) {
        historyDateService.createHistoryDate(historyDateDto);
        return new ModelAndView("redirect:/web/list");
    }

    @GetMapping("/period/form")
    public ModelAndView showAddPeriodForm(Map<String, Object> model) {
        PeriodDto periodDto = new PeriodDto();
        model.put("periodDto", periodDto);
        return new ModelAndView("add-period", model);
    }

    @PostMapping("/period/form")
    public ModelAndView addPeriod(@ModelAttribute PeriodDto periodDto) {
        periodService.createCentury(periodDto);
        return new ModelAndView("redirect:/web/list");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateHistoryDateForm(@PathVariable Long id, Map<String, Object> model) {
        HistoryDateDto historyDateDto = historyDateService.getHistoryDateById(id);
        model.put("centuries", periodService.getAllCentury());
        model.put("historyDateDto", historyDateDto);
        return new ModelAndView("update-history-date", model);
    }

    @PostMapping("/update")
    public ModelAndView updateHistoryDate(@ModelAttribute HistoryDateDto historyDateDto) {
        historyDateService.updateHistoryDate(historyDateDto.getId(), historyDateDto);
        return new ModelAndView("redirect:/web/list");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteHistoryDate(@PathVariable Long id) {
        historyDateService.deleteHistoryDateById(id);
        return new ModelAndView("redirect:/web/list");
    }

}
